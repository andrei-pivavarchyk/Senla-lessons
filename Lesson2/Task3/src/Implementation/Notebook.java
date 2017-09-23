package Implementation;
import Contracts.IProduct;
import Contracts.IProductPart;

public class Notebook implements IProduct{

    private IProductPart firstPart;
    private  IProductPart secondPart;
    private IProductPart thirdPart;



    public void InstallFirstPart(IProductPart firstProductPart) {
        this.firstPart=firstProductPart;

    System.out.println("First Part installed");
    }

    public void InstallSecondPart(IProductPart secondProductPart)
    {
        this.secondPart=secondProductPart;
        System.out.println("Second Part installed");
    }

    public void InstallThirdPart(IProductPart thirdProductPart)
    {
        this.thirdPart=thirdProductPart;

        System.out.println("Third Part installed");
    }
}