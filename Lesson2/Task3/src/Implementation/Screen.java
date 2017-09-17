package Implementation;

import Contracts.IProductPart;

public class Screen implements IProductPart {
    public Size GetSize() {
        return new Size(3,7);
    }
}
