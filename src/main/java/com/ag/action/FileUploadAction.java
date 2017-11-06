package com.ag.action;

import net.sourceforge.stripes.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by agufed on 11/5/17.
 */
@UrlBinding("/file_upload")
public class FileUploadAction extends BaseActionBean{
    private Logger log = LoggerFactory.getLogger(UserAction.class);

    private List<FileBean> newAttachments;

    public List<FileBean> getNewAttachments() {
        return this.newAttachments;
    }

    public void setNewAttachment(List<FileBean> newAttachments) {
        this.newAttachments = newAttachments;
    }


    @RolesAllowed(value= {"all"} )
    @HandlesEvent("file_upload")
    public Resolution fileUploadForm(){
        log.info("fileUploadForm........");
        return new ForwardResolution("/pages/fileUpload.jsp");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("process_upload")
    public Resolution processFileUpload(){
        log.info("processFileUpload..." + getNewAttachments().size());
        return sendResponse(getJsonString(getNewAttachments()), "success");
    }

}
