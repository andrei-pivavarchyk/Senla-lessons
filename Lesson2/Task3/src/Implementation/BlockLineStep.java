package Implementation;

import Contracts.ILineStep;
import Contracts.IProductPart;

public class BlockLineStep implements ILineStep {
    @Override
    public IProductPart BuildProductPart() {
        System.out.println("Building Block.");
        return new Block();
    }
}
