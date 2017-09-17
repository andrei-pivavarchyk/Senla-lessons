package Implementation;

import Contracts.IAssemblyLine;
import Contracts.ILineStep;
import Contracts.IProduct;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AssemblyLine implements IAssemblyLine {
    private ArrayList<ILineStep> _lineSteps = new ArrayList<>();

    public void AddLineStep(ILineStep lineStep){
        if(_lineSteps.size() > 3){
            throw new IllegalArgumentException("Cannot have more than 3 line steps!");
        }

        _lineSteps.add(lineStep);
    }

    public IProduct AssembleProduct(IProduct product) {
        if (_lineSteps.size() != 3){
            throw new UnsupportedOperationException("Cannot have more than 3 line steps!");
        }

        for (int i=0; i< 3; i++){
            switch (i){
                case 0:
                    product.InstallFirstPart(_lineSteps.get(i).BuildProductPart());
                    break;
                case 1:
                    product.InstallSecondPart(_lineSteps.get(i).BuildProductPart());
                    break;
                case 2:
                    product.InstallThirdPart(_lineSteps.get(i).BuildProductPart());
                    break;
            }
        }

        System.out.println("Product was built");
        return  product;
    }
}
