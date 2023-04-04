package iniko.Voda.Services.Initializers;

import iniko.Voda.DTO.*;
import iniko.Voda.Services.DB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
public class BasicInitialize {

    @Autowired
    private OrderCategoryService orderCategoryService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileTypeService fileTypeService;

    public BasicInitialize() {

    }

    public BasicInitialize(int prTps,int prCts,int ordCts,int flTps,int fils) {
        InitializeProductType(prTps);
        InitializeProductCategory(prCts);
        InitializeOrderCategory(ordCts);
        InitializeFileType(flTps);
        InitializeFile(fils);
        InitializeProducts();
        InitializeUsers();

    }

    public void InitializeProductType(int Num)
    {
        ProductType productType;
        for (int i = 0; i < Num; i++) {
            productType=new ProductType();
            productType.setType(GenRandomString());
            productTypeService.CreateProductType(productType);
        }
    }
    public void InitializeProductCategory(int Num)
    {
        ProductCategory productCategory;
        for (int i = 0; i < Num; i++) {
            productCategory=new ProductCategory(i,GenRandomString(),GetNow());
            productCategoryService.CreateProductCategory(productCategory);
        }

    }
    public void InitializeOrderCategory(int Num)
    {
        OrderCategory orderCategory;
        for (int i = 0; i < Num; i++) {
            orderCategory=new OrderCategory(i,GenRandomString(),GetNow());
            orderCategoryService.CreateOrderCategory(orderCategory);
        }
    }
    public void InitializeFileType(int Num)
    {
        FileType fileType;
        for (int i = 0; i < Num; i++) {
            fileType=new FileType(i,GenRandomString());
            fileTypeService.CreateFileType(fileType);
        }
    }
    public void InitializeFile(int Num)
    {
        File file;
        for (int i = 1; i < Num; i++) {
            file=new File(i,GenRandomString(),GenRandomString(),GetNow(),fileTypeService.GetFileTypeByID(GenRandomInt()+1));
            fileService.CreateFile(file);
        }
    }

    public void InitializeProducts()
    {
        Product product;
        for (int i = 0; i < 100; i++) {
            product=new Product();
            ProductCategory category=productCategoryService.GetProductCategoryByID(GenRandomInt()+1);
            product.setCategory(category);
            product.setDescription(GenRandomString());
            //product.setType(productTypeService.GetProductTypeByID(GenRandomInt()+1));
            ProductType productType=productTypeService.GetProductTypeByID(GenRandomInt()+1);
            product.setType(productType);
            product.setName(GenRandomString());
            product.setDateAdded(GetNow());
            List<File> files=fileService.GetAllFiles();
            List<File> fileList = new ArrayList<>();
            fileList.add(files.get(i));
            product.setFilesRelated(fileList);
            product.setPrice(GenRandomPrice());
            product.setRating(GenRandomInt());
            productService.CreateProduct(product);
        }

    }
    public void InitializeUsers()
    {
        createAdmin();
        createMainTest();
        User user;
        for (int i = 0; i < 10; i++) {
            user=new User();
            user.setUsername(GenRandomString()+"_TEST");
            user.setPassword("SR"+GenRandomString());
            user.setAdmin(false);
            user.setActive(true);
            user.setMobile("012345678910");
            user.setDateCreated(GetNow());
            user.setName(GenRandomString());
            user.setSurname(GenRandomString());
            user.setLastLogIn(null);
            userService.CreateUser(user);
        }
    }
    private void createAdmin()
    {
        User admin=new User();
        admin.setUsername("admin");
        admin.setPassword("sa");
        admin.setAdmin(true);
        admin.setActive(true);
        admin.setMobile("012345678910");
        admin.setDateCreated(GetNow());
        admin.setName(GenRandomString());
        admin.setSurname(GenRandomString());
        admin.setLastLogIn(null);
        userService.CreateUser(admin);
    }
    private void createMainTest()
    {
        User test=new User();
        test.setUsername("user");
        test.setPassword("sa");
        test.setAdmin(false);
        test.setActive(true);
        test.setMobile("012345678910");
        test.setDateCreated(GetNow());
        test.setName(GenRandomString());
        test.setSurname(GenRandomString());
        test.setLastLogIn(null);
        userService.CreateUser(test);
    }
    /*private List<Object> SetObjectsNum(Object obj, Class obj.Class, int Interations)
    {
        List<Object> objectList;
        for (int i = 0; i < Interations; i++) {

        }
    }*/

    private String GenRandomString()
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return (random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }

    private Integer GenRandomInt()
    {
        Random rand = new Random();
        // Setting the upper bound to generate the
        // random numbers in specific range
        int upperbound = 6;
        // Generating random values from 0 - 24
        // using nextInt()
        return rand.nextInt(upperbound);
    }
    private Integer GenRandomPrice()
    {
        Random rand = new Random();
        // Setting the upper bound to generate the
        // random numbers in specific range
        int upperbound = 100;
        // Generating random values from 0 - 24
        // using nextInt()
        return rand.nextInt(upperbound);
    }
    private Date GetNow()
    {
        Date dateOne = new Date();
        Instant inst = Instant.now();
        return dateOne.from(inst);
    }
}
