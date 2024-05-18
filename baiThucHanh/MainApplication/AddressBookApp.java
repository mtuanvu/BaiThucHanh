package baiThucHanh.MainApplication;

import baiThucHanh.Controller.AddressBookController;
import baiThucHanh.View.AddressBookView;
import baiThucHanh.model.ContactDAO;

public class AddressBookApp {
    public static void main(String[] args) {
        ContactDAO model = new ContactDAO();
        AddressBookView view = new AddressBookView();
        AddressBookController controller = new AddressBookController(model, view);
        controller.run();
    }
}
