package uz.online.teacher.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/***
 * 1. oldin guruh yaratiladi
 * 2. yaratilgan guruh ichiga kirib yangi o`quvchi qo`shiladi
 * 3. guruhga o`quvchi qo`shish ikki xil bo`ladi
 * 1) yangi sozdat qilish
 * 2) ro`yxatdan qo`shish
 * yangi o`quvchi qo`shayotganda boshqa fanlari haqidagi ma`lumot ham kelishi kerak
 * yangi o`quvchi o`quvchining passport seriya nomeri yoki guvohnoma seriya nomeri orqali qo`shiladi
 * dars uchun alohida model qilish kerak, unda hafta kuni va darslarning boshlanish va tugash vaqtlari kiritiladi
 * guruhda o`quvchilar royxati, jurnal, to`lovlar haqidagi ma`lumotlar bo`lishi kerak
 ***/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "groups")
public class Group extends BaseEntity {
    private String name;
    private Integer orderNumber;
    @ManyToOne
    private Subject subject;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private User teacher;
    @ManyToOne
    private SchoolYear schoolYear;
    private boolean isActive = true;
}
