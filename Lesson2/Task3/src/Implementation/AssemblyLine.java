package Implementation;
import Contracts.IAssemblyLine;
import Contracts.ILineStep;
import Contracts.IProduct;
import Contracts.IProductPart;

   public class AssemblyLine implements IAssemblyLine{
   private ILineStep[] allSteps;


  public AssemblyLine (ILineStep[] allSteps ){
       this.allSteps=allSteps;
   }

    public IProduct AssembleProduct(IProduct product) {



             product.InstallFirstPart( (IProductPart) allSteps[0].BuildProductPart() );
             product.InstallSecondPart( (IProductPart) allSteps[1].BuildProductPart() );
             product.InstallThirdPart( (IProductPart) allSteps[2].BuildProductPart() );

System.out.print("Product was built");
      return product;
    }
}