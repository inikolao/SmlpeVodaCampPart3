package iniko.Voda.Services.DB;

import iniko.Voda.DTO.Product;
import iniko.Voda.DTO.User;
import iniko.Voda.DTO.WishList;
import iniko.Voda.Repos.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishListRepo whishListRepo;

    public void CreateWhishList(User user)
    {
        WishList whshList=new WishList(user);
        whishListRepo.save(whshList);

    }

    public WishList findWishListByUser(User user)
    {
        return  whishListRepo.findByUserOwner(user);
    }

    public WishList findWhshListById(int id){
        return whishListRepo.findWhshListById(id);
    }

    public void addProductToWhish(Product product,int id)
    {
        WishList wlist=whishListRepo.findWhshListById(id);
        List<Product>products=wlist.getProductList();
        products.add(product);
    }
    public void removeProductToWhish(Product product,int id)
    {
        WishList wlist=whishListRepo.findWhshListById(id);
        List<Product>products=wlist.getProductList();
        products.remove(product);
    }
}
