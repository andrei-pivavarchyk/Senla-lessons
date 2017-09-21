package Implementation;
import Contracts.IProduct;
import Contracts.IProductPart;

public class Notebook implements IProduct{



    public void InstallFirstPart(IProductPart FirstProductPart) {

    System.out.println("First Part installed");
    }

    public void InstallSecondPart(IProductPart SecondProductPart)
    {

        System.out.println("Second Part installed");
    }

    public void InstallThirdPart(IProductPart ThirdProductPart)
    {

        System.out.println("Third Part installed");
    }
}