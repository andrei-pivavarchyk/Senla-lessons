import Contracts.ILineStep;
import Implementation.*;

public class Program {
    public static void main ( String [] arguments )
    {
        System.out.println("Starting app.");

        AssemblyLine al = new AssemblyLine();
        al.AddLineStep(new BlockLineStep());
        al.AddLineStep(new ScreenLineStep());
        al.AddLineStep(new MotherBoardLineStep());

        al.AssembleProduct(new Notebook());
        System.out.println("Done...");
    }
}
