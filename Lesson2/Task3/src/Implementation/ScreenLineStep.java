package Implementation;

import Contracts.ILineStep;
import Contracts.IProductPart;

public class ScreenLineStep implements ILineStep{

    @Override
    public IProductPart BuildProductPart() {
        System.out.println("Building screen.");
        return new Screen();
    }
}
