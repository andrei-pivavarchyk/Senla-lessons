package Implementation;

import Contracts.ILineStep;
import Contracts.IProductPart;

public class MotherBoardLineStep implements ILineStep {
    public IProductPart BuildProductPart() {
        System.out.println("Building motherboard.");
        return new MotherBoard();
    }
}
