package Implementation;

import Contracts.IProductPart;

public class Block implements IProductPart {
    public Size GetSize() {
        return new Size(2,3);
    }
}
