package Implementation;

import Contracts.ILineStep;
import Contracts.IProductPart;
import Implementation.Parts.Screen;

public class ScreenLineStep implements ILineStep {

    public IProductPart BuildProductPart() {
        System.out.println("Building Screen.");
        return new Screen();
    }
}
