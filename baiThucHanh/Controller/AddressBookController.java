package baiThucHanh.Controller;

import baiThucHanh.View.AddressBookView;
import baiThucHanh.model.ContactDAO;
import baiThucHanh.entity.Contact;

public class AddressBookController {
    private ContactDAO model;
    private AddressBookView view;

    public AddressBookController(ContactDAO model, AddressBookView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        int choice;
        do {
            choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContactByName();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Đang thoát...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số từ 1 đến 4.");
            }
        } while (choice != 4);
    }

    private void addContact() {
        Contact newContact = view.getNewContactInfo();
        model.addContact(newContact);
        System.out.println("Liên hệ đã được thêm thành công!");
    }

    private void findContactByName() {
        String name = view.getContactName();
        Contact contact = model.findContactByName(name);
        view.displayContact(contact);
    }

    private void displayContacts() {
        view.displayContacts(model.getAllContacts());
    }
}
