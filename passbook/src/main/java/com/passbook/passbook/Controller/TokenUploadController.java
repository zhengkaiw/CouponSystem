package com.passbook.passbook.Controller;

import com.passbook.passbook.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * PassTemplate Token Upload
 */
@Slf4j
@Controller
public class TokenUploadController {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public TokenUploadController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/token")
    public String tokenFileUpload(@RequestParam("merchantsId") String merchantsId,
                                  @RequestParam("postTemplate") String passTemplateId,
                                  @RequestParam("file")MultipartFile file,
                                  RedirectAttributes redirectAttributes) {

        if (null == passTemplateId || file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message",
                    "passTemplateId is null or file is empty");
            return "redirect:/uploadStatus";
        }

        try {
            File cur = new File(Constants.TOKEN_DIR + merchantsId);
            if (!cur.exists()) {
                log.info("Create File: {}", cur.mkdir());
            }
            Path path = Paths.get(Constants.TOKEN_DIR, merchantsId, passTemplateId);
            Files.write(path, file.getBytes());

            if (!writeTokenToRedis(path, passTemplateId)) {
                redirectAttributes.addFlashAttribute("message",
                        "write token error");
            } else {
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    /**
     * 将 token 写入 redis
     * @param path {@link Path}
     * @param key redis key
     * @return true/false
     */
    private boolean writeTokenToRedis(Path path, String key) {

        Set<String> tokens;

        try (Stream<String> stream = Files.lines(path)){
            tokens = stream.collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (!CollectionUtils.isEmpty(tokens)) {
            redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
                for (String token : tokens) {
                    connection.sAdd(key.getBytes(), token.getBytes());
                }
                return null;
            });
        }

        return false;
    }
}
