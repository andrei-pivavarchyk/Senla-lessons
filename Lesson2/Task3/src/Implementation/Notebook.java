package Implementation;

import Contracts.IProduct;
import Contracts.IProductPart;

public class Notebook implements IProduct {
    public void InstallFirstPart(IProductPart iProductPart) {
        System.out.println("Installing first part.");
    }

    public void InstallSecondPart(IProductPart iProductPart) {
        System.out.println("Installing second part.");
    }

    public void InstallThirdPart(IProductPart iProductPart) {
        System.out.println("Installing third part.");
    }
}
