package ui.action;

import ui.entity.ActionEnumResult;

public class ActionPreviosMenu extends AAction implements IAction {
    @Override
    public ActionEnumResult execute() {

        return ActionEnumResult.PREVIOUS;
    }
}
