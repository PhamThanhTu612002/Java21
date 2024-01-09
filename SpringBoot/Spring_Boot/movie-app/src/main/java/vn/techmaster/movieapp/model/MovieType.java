package vn.techmaster.movieapp.model;

public enum MovieType {
    PHIM_LE("Phim Lẻ"),
    PHIM_BO("Phim Bộ"),
    PHIM_CHIEU_RAP("Phim Chiếu Rạp");

    private final String value;
    MovieType(String value) {
        this.value = value;
    }
}
