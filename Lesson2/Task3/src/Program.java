import Contracts.IProduct;
import Implementation.AssemblyLine;
import Implementation.Notebook;

public class Program {
    public static void main ( String [] arguments )
    {
       AssemblyLine Line = new AssemblyLine();
       Line.AssembleProduct(new Notebook());


    }
}
