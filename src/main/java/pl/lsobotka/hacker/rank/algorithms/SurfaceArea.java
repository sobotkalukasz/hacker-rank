package pl.lsobotka.hacker.rank.algorithms;

import java.util.Arrays;

/*
 * https://www.hackerrank.com/challenges/3d-surface-area/problem
 */
public class SurfaceArea {

    static int surfaceArea(Integer[][] arr) {

        int h = arr.length;
        int w = arr[0].length;

        int topSurface = h * w;
        int bottomSurface = h * w;
        int northSurface = calcNorth(h, w, arr);
        int westSurface = calcWest(h, w, arr);
        int southSurface = calcSouth(h, w, arr);
        int eastSurface = calcEast(h, w, arr);

        return topSurface + bottomSurface + northSurface + westSurface + southSurface + eastSurface;
    }

    private static int calcNorth(int h, int w, Integer[][] arr) {

        if (h == 1) {
            return Arrays.stream(arr[h - 1]).mapToInt(Integer::intValue).sum();
        }

        int surface = 0;

        for (int firstDim = 0; firstDim < h; firstDim++) {
            for (int secDim = 0; secDim < w; secDim++) {
                if (firstDim == 0) {
                    surface += arr[firstDim][secDim];
                    continue;
                }
                int previousElement = arr[firstDim - 1][secDim];
                int actualElement = arr[firstDim][secDim];
                surface += previousElement < actualElement ? actualElement - previousElement : 0;
            }
        }
        return surface;
    }

    private static int calcWest(int h, int w, Integer[][] arr) {
        if (w == 1) {
            return Arrays.stream(arr).flatMapToInt(num -> Arrays.stream(num).mapToInt(Integer::intValue)).sum();
        }

        int surface = 0;

        for (int secDim = 0; secDim < w; secDim++) {
            for (int firstDim = 0; firstDim < h; firstDim++) {
                if (secDim == 0) {
                    surface += arr[firstDim][secDim];
                    continue;
                }
                int previousElement = arr[firstDim][secDim - 1];
                int actualElement = arr[firstDim][secDim];
                surface += previousElement < actualElement ? actualElement - previousElement : 0;
            }
        }
        return surface;
    }

    private static int calcSouth(int h, int w, Integer[][] arr) {
        if (h == 1) {
            return Arrays.stream(arr[h - 1]).mapToInt(Integer::intValue).sum();
        }

        int surface = 0;

        for (int firstDim = h - 1; firstDim > 0; firstDim--) {
            for (int secDim = 0; secDim < w; secDim++) {
                if (firstDim == h - 1) {
                    surface += arr[firstDim][secDim];
                }
                int actualElement = arr[firstDim][secDim];
                int previousElement = arr[firstDim - 1][secDim];
                surface += actualElement < previousElement ? previousElement - actualElement : 0;
            }
        }
        return surface;
    }

    private static int calcEast(int h, int w, Integer[][] arr) {
        if (w == 1) {
            return Arrays.stream(arr).flatMapToInt(num -> Arrays.stream(num).mapToInt(Integer::intValue)).sum();
        }

        int surface = 0;

        for (int secDim = w - 1; secDim > 0; secDim--) {
            for (int firstDim = 0; firstDim < h; firstDim++) {
                if (secDim == w - 1) {
                    surface += arr[firstDim][secDim];
                }
                int actualElement = arr[firstDim][secDim];
                int previousElement = arr[firstDim][secDim - 1];
                surface += actualElement < previousElement ? previousElement - actualElement : 0;
            }
        }
        return surface;
    }
}
