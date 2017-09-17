package vn.myclass.command;

import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.dto.SlideDTO;
import vn.myclass.core.web.command.AbstractCommand;

public class SlideCommand extends AbstractCommand {
    public SlideCommand(){
        this.pojo = new SlideDTO();
    }
}
