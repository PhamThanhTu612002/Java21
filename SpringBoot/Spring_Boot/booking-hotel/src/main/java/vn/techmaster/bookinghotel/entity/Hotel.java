package vn.techmaster.bookinghotel.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String  address;
    String poster;
    String slug;
    Integer rating_star;

    @Transient
    Integer rating_review;
    public String getRatingText() {
        if (rating_review == null) {
            return "Chưa có đánh giá";
        }

        // switch rating from 1 to 10
        return switch (rating_review) {
            case 1 -> "Tệ";
            case 2 -> "Kém";
            case 3 -> "Trung bình";
            case 4 -> "Tạm được";
            case 5 -> "Hay";
            case 6 -> "Rất hay";
            case 7 -> "Tuyệt vời";
            case 8 -> "Tuyệt hảo";
            case 9 -> "Xuất sắc";
            case 10 -> "Quá tuyệt vời";
            default -> "Chưa có đánh giá";
        };
    }
    @Column(columnDefinition = "TEXT")
    String description;
    Boolean status;
    Integer check_in;
    Integer check_out;
    Date createdAt;
    Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "province_id")
    Province province;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToMany
    @JoinTable(name = "hotel_utility",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "utility_id")
    )
    private List<Utility> utilities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hotel_image",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> imageList;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY)
    private List<HotelRoom> hotelRooms;
}
