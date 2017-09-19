package Implementation;

import Contracts.ILineStep;
import Contracts.IProductPart;
import Implementation.Parts.MotherBoard;

public class MotherBoardLineStep implements ILineStep {

    public IProductPart BuildProductPart() {
        System.out.println("Building MotherBoard.");
        return new MotherBoard();
    }
}