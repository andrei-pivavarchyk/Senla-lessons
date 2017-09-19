package Implementation;
import Contracts.IAssemblyLine;
import Contracts.ILineStep;
import Contracts.IProduct;
import Contracts.IProductPart;




public class AssemblyLine implements IAssemblyLine{

   public ILineStep[] allSteps=new ILineStep[3];

    public IProduct AssembleProduct(IProduct product) {


        this.allSteps[0]=new ScreenLineStep();
        this.allSteps[1]=new BlockLineStep();
        this.allSteps[2]=new MotherBoardLineStep();


             product.InstallFirstPart( (IProductPart) allSteps[0].BuildProductPart() );
             product.InstallSecondPart( (IProductPart) allSteps[1].BuildProductPart() );
             product.InstallThirdPart( (IProductPart) allSteps[2].BuildProductPart() );

System.out.print("Product was built");
      return product;
    }
}