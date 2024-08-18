/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.handroid.spring_ci_cd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PreDestroy;

@Slf4j
@SpringBootApplication
public class MicroserviceTemplateApplication {

    public static final String PASSWORD = "12345";

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceTemplateApplication.class, args);
//        encrypt();
    }

    private static void encrypt() {
        System.out.println(new BCryptPasswordEncoder().encode(PASSWORD));
    }

    /**
     * Register shutdown hook to listen for termination signal.
     */
    @PreDestroy
    public void tearDown() {
        // Clean up resources on shutdown
        log.info("{}: received SIGTERM.", MicroserviceTemplateApplication.class.getSimpleName());
        // Flush async logs if needed - current Logback config does not buffer logs
    }
}

// 1:51:11
// 2:06:45
