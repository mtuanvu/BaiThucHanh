package baiThucHanh.view;

import baiThucHanh.entity.Contact;

import java.util.List;
import java.util.Scanner;

public class AddressBookView {
    private Scanner scanner;

    public AddressBookView() {
        scanner = new Scanner(System.in);
    }

    public int getMenuChoice() {
        System.out.println("\nMenu:");
        System.out.println("1. Thêm liên hệ mới");
        System.out.println("2. Tìm liên hệ theo tên");
        System.out.println("3. Hiển thị tất cả liên hệ");
        System.out.println("4. Thoát");
        System.out.println("Nhập lựa chọn của bạn:");
        return scanner.nextInt();
    }

    public Contact getNewContactInfo() {
        scanner.nextLine(); // Đọc bỏ dòng mới
        System.out.println("Nhập Tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập Công ty:");
        String company = scanner.nextLine();
        System.out.println("Nhập Email:");
        String email = scanner.nextLine();
        System.out.println("Nhập Số điện thoại:");
        String phone = scanner.nextLine();
        return new Contact(name, company, email, phone);
    }

    public String getContactName() {
        scanner.nextLine(); // Đọc bỏ dòng mới
        System.out.println("Nhập Tên để tìm:");
        return scanner.nextLine();
    }

    public void displayContact(Contact contact) {
        if (contact != null) {
            System.out.printf("%-30s %-35s %-35s %-15s\n", "Contact Name", "Company", "Email", "Phone number");
            System.out.printf("%-30s %-35s %-35s %-15s\n", contact.getName(), contact.getCompany(), contact.getEmail(), contact.getPhone());
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    public void displayContacts(List<Contact> contacts) {
        System.out.printf("%-30s %-35s %-35s %-15s\n", "Contact Name", "Company", "Email", "Phone number");
        for (Contact contact : contacts) {
            System.out.printf("%-30s %-35s %-35s %-15s\n", contact.getName(), contact.getCompany(), contact.getEmail(), contact.getPhone());
        }
    }
}
