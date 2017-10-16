package action;

import entity.ActionEnumResult;

public class ActionPreviosMenu implements IAction {
    @Override
    public ActionEnumResult execute() {


        return ActionEnumResult.PREVIOUS;
    }
}
