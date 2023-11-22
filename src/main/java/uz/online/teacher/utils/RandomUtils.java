package uz.online.teacher.utils;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class RandomUtils {

    public static String generateCode(int n) {
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < n; i++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
    }
}
