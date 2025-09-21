import java.util.*;

class MovieRentingSystem {
    class MovieInfo implements Comparable<MovieInfo> {
        int price, shop, movie;

        MovieInfo(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        public int compareTo(MovieInfo other) {
            if (this.price != other.price) return this.price - other.price;
            if (this.shop != other.shop) return this.shop - other.shop;
            return this.movie - other.movie;
        }
    }

    Map<Integer, TreeSet<MovieInfo>> available;  // movie -> shops with unrented copies
    TreeSet<MovieInfo> rented;                    // all rented movies
    Map<String, MovieInfo> map;                  // "shop#movie" -> MovieInfo

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>();
        map = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            MovieInfo mi = new MovieInfo(shop, movie, price);
            available.computeIfAbsent(movie, k -> new TreeSet<>()).add(mi);
            map.put(shop + "#" + movie, mi);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        TreeSet<MovieInfo> set = available.get(movie);
        int count = 0;
        for (MovieInfo mi : set) {
            if (count++ == 5) break;
            res.add(mi.shop);
        }
        return res;
    }

    public void rent(int shop, int movie) {
        MovieInfo mi = map.get(shop + "#" + movie);
        available.get(movie).remove(mi);
        rented.add(mi);
    }

    public void drop(int shop, int movie) {
        MovieInfo mi = map.get(shop + "#" + movie);
        rented.remove(mi);
        available.get(movie).add(mi);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (MovieInfo mi : rented) {
            if (count++ == 5) break;
            res.add(Arrays.asList(mi.shop, mi.movie));
        }
        return res;
    }
}
