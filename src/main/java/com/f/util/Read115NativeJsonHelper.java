package com.f.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用于读取115导出json文件内容
 * <p>
 * 内容格式为:
 * <pre>
 *     {@code
 *          {
 *              "dir_name": "root",
 *              "files": [],
 *              "dirs": [
 *                  {
 *                      "dir_name": "bar",
 *                      "files": ["a", "b"],
 *                      "dirs": []
 *                  }
 *              ]
 *          }
 *     }
 * </pre>
 * <p>
 * created by f at 2021/7/7 16:47
 */
public class Read115NativeJsonHelper {
    static class DirItem {
        private String dir_name;
        private List<String> files;
        private List<DirItem> dirs;

        static void readAllFiles(DirItem dirItem) {
            for (String hashLink : dirItem.files) {
                System.out.println(hashLink);
            }
            if (dirItem.dirs.size() > 0) {
                for (DirItem childItem : dirItem.dirs) {
                    readAllFiles(childItem);
                }
            }
        }

        static void readSpecialFiles(DirItem dirItem, Pattern pattern) {
            Matcher matcher;
            for (String hashLink : dirItem.files) {
                matcher = pattern.matcher(hashLink);
                if (matcher.find()) {
                    System.out.println(hashLink);
                }
            }
            if (dirItem.dirs.size() > 0) {
                for (DirItem childItem : dirItem.dirs) {
                    readSpecialFiles(childItem, pattern);
                }
            }
        }

        public String getDir_name() {
            return dir_name;
        }

        public void setDir_name(String dir_name) {
            this.dir_name = dir_name;
        }

        public List<String> getFiles() {
            return files;
        }

        public void setFiles(List<String> files) {
            this.files = files;
        }

        public List<DirItem> getDirs() {
            return dirs;
        }

        public void setDirs(List<DirItem> dirs) {
            this.dirs = dirs;
        }
    }


    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DirItem dirItem = objectMapper.readValue(new File("C:\\Users\\f\\Downloads\\6.1献礼\\JSON文件转存\\@115sha1_日系步兵_560GB 418文件.json"), DirItem.class);
        Pattern pattern = Pattern.compile("(?i)rmvb|avi|mpeg|mpg|mkv|wmv|mp4");
        DirItem.readSpecialFiles(dirItem, pattern);
    }

}
