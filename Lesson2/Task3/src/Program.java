import Contracts.ILineStep;
import Contracts.IProduct;
import Implementation.*;

public class Program {
    public static void main ( String [] arguments )
    {


        ILineStep[] allSteps=new ILineStep[3];
        allSteps[0]= new BlockLineStep();
        allSteps[1]=new MotherBoardLineStep();
        allSteps[2]=new ScreenLineStep();

       AssemblyLine Line = new AssemblyLine(allSteps);

       Line.AssembleProduct(new Notebook());


    }
}
