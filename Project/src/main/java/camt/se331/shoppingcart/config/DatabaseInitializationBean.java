package camt.se331.shoppingcart.config;

import camt.se331.shoppingcart.entity.*;
import camt.se331.shoppingcart.repository.*;
import camt.se331.shoppingcart.service.ImageUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Dto on 2/11/2015.
 */
@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public void afterPropertiesSet() throws Exception {
        Product[] initProduct =  {
                new Product(1l,"Tod Pra Pa","Invitation for Tod Pra Pa and participated.","28/6/2015", ImageUtil.getImage("pic/IMG_1382(1).jpg")),
                new Product(2l,"The ordination","Invitation for the ordination","23/5/2015",ImageUtil.getImage("pic/5.jpg")),
                new Product(3l,"Suadmon Kam Pee"," You are invited to Suadmon Kam Pee To a fortune.","31/12/2015-1/1/2016",ImageUtil.getImage("pic/3.jpg")),
                new Product(4l,"Sarakkapat","There are are plenty beer and wine fairs.","19/09/2015",ImageUtil.getImage("pic/4.jpg")),
               new Product(5l,"Ignoring the killing cattle","The temple was held to reduce the slaughter of cattle.","5/12/2015",ImageUtil.getImage("pic/5.jpg"))
        };


//        Product[] initProduct =  {
//                new Product(1l,"Tod Pra Pa","Invitation for Tod Pra Pa and participated.","28/6/2015", ImageUtil.getImage("pic/IMG_1382(1).jpg")),
//                new Product(2l,"The ordination","Invitation for the ordination","23/5/2015",ImageUtil.getImage("pic/why54_19.jpg")),
//                new Product(3l,"Suadmon Kam Pee"," You are invited to Suadmon Kam Pee To a fortune.","31/12/2015-1/1/2016",ImageUtil.getImage("pic/3.jpg")),
//                new Product(4l,"Sarakkapat","There are are plenty beer and wine fairs.","19/09/2015",ImageUtil.getImage("pic/4.jpg")),
//                new Product(5l,"Ignoring the killing cattle","The temple was held to reduce the slaughter of cattle.","5/12/2015",ImageUtil.getImage("pic/5.jpg")),
//                new Product(6l,"Telephone", "Call the others","20/12/36",ImageUtil.getImage("pic/x.png")),
//                new Product(7l,"iPhone","What is it?","20/12/36",ImageUtil.getImage("pic/x.png")),
//                new Product(8l,"Galaxy Note 4","Who still use this ?","20/12/36",ImageUtil.getImage("pic/x.png")),
//                new Product(9l,"AngularJS","we hate it","20/12/36",ImageUtil.getImage("pic/x.png")),
//                new Product(10l,"Mazda 3","Very handsome guy use this","20/12/36",ImageUtil.getImage("pic/x.png"))
//        };

        productRepository.save(Arrays.asList(initProduct));
        historyRepository.save(new History(1l,"en","Thi is Temple"));


        ShoppingCart shoppingCart = new ShoppingCart();
        List<SelectedProduct> selectedProducts = new ArrayList<>();
        SelectedProduct[] initSelectedProduct = {
                new SelectedProduct(initProduct[2], 5),
                new SelectedProduct(initProduct[4], 2),
                new SelectedProduct(initProduct[1], 1),
        };
        selectedProducts.addAll(Arrays.asList(initSelectedProduct));
        Calendar calendar = new GregorianCalendar(2015,4,7);
        shoppingCart.setSelectedProducts(selectedProducts);
        shoppingCart.setPurchaseDate(calendar.getTime());
        shoppingCart.setId(1L);
        shoppingCartRepository.save(shoppingCart);

        // add user
        Role adminRole = new Role("admin");
        Role userRole = new Role("user");


        User admin = new User();
        admin.setName("admin");
        admin.setUsername("admin");
        admin.setEmail("admin@yahoo.com");
        admin.setPassword("123456");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        User user = new User();
        user.setName("user");
        user.setUsername("user");
        user.setEmail("user@yahoo.com");
        user.setPassword("123456");
        Set<Role> roles2 = new HashSet<>();
        roles2.add(userRole);
        user.setRoles(roles2);
        userRepository.save(admin);
        userRepository.save(user);
        admin.setRoles(roles);
        user.setRoles(roles2);
    }
}
