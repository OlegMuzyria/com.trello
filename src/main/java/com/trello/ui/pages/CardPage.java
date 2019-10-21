package com.trello.ui.pages;

import com.trello.ui.core.Constants;
import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.ui.core.BrowserFactory.*;

public class CardPage {

    private static final String PATH = "c/";

    public Elem membersBtn = new Elem(By.cssSelector(".js-change-card-members"), "Members button");
    public Elem selectMemberBtn = new Elem(By.cssSelector(".js-select-member"), "Select ember button");
    public Elem labelsBtn = new Elem(By.cssSelector(".js-edit-labels"), "Labels button");
    public Elem yellowLabelBtn = new Elem (By.cssSelector(".card-label-yellow"), "Green label button");
    public Elem closePopUpBtn = new Elem (By.cssSelector(".pop-over-header-close-btn"), "Close Pop Up button");
    public Elem checklistBtn = new Elem(By.cssSelector(".js-add-checklist-menu"), "Checklist button");
    public Elem checklistNameInput = new Elem (By.cssSelector("#id-checklist"), "Check list name input");
    public Elem checkListItemInput = new Elem (By. cssSelector(".js-new-checklist-item-input"), "Check list item input");
    public Elem checklistItem = new Elem (By.cssSelector(".js-checkitem-name"), "Check list item");
    public Elem addChecklistBtn = new Elem (By.cssSelector(".js-add-checklist"), "Add checklist button");
    public Elem confirmChecklistItemBtn = new Elem (By.cssSelector(".js-add-checklist-item"), "Add item button");
    public Elem checklistItemCheckbox = new Elem (By.cssSelector(".js-toggle-checklist-item"), "Checkbox for checklist item");
    public Elem checklistItemMenu = new Elem (By.cssSelector(".checklist-item-menu"));
    public Elem ConvertToCardchecklistItemMenu = new Elem (By.cssSelector(".js-convert-to-card"));
    public Elem checklistItemRow = new Elem (By.cssSelector(".checklist-item-row"));
    public Elem deleteChecklistItemBtn = new Elem (By.cssSelector(".js-delete"), "Delete checklist item button");
    public Elem confirmDeleteBtn = new Elem (By.cssSelector(".js-confirm"), "Delete checklist confirm pop up");
    public Elem linkInput = new Elem (By.cssSelector("#addLink"), "Link input");
    public Elem linkNameInput = new Elem (By.cssSelector("#nameLink"), "Link name input");
    public Elem attachBtn = new Elem (By.cssSelector(".js-add-attachment-url"), "Attach button");
    public Elem attachmentPreview = new Elem (By.cssSelector(".attachment-thumbnail-details"), "Attachment preview");
    public Elem dueDateBtn = new Elem(By.cssSelector(".js-add-due-date"), "Due Date button");
    public Elem attachmentBtn = new Elem(By.cssSelector("a[class=\"button-link js-attach\"]"), "Attachment button");
    public Elem deleteAttachmentBtn = new Elem (By.cssSelector(".js-confirm-delete"), "Delete attachement button");
    public Elem moveCardBtn = new Elem(By.cssSelector(".js-move-card"), "Move button");
    public Elem copyCardBtn = new Elem(By.cssSelector(".js-copy-card"), "Copy Button");
    public Elem boardSelect = new Elem(By.cssSelector(".js-select-board"), "Select board");
    public Elem listSelect  = new Elem (By.cssSelector(".js-select-list"), "Select list");
    public Elem createCardBtn = new Elem (By.cssSelector(".js-submit"), "Create Card button");
    public Elem listOptionValue = new Elem (By.cssSelector(".js-select-list [value = \"5d19dafdfa1c69552a41c303\"]"), "List ID in select option");
    public Elem watchBtn = new Elem(By.cssSelector(".js-subscribe"), "Watch button");
    public Elem archiveBtn = new Elem(By.cssSelector(".js-archive-card"), "Archive button");
    public Elem shareBtn = new Elem(By.cssSelector(".js-more-menu"), "Share button");
    public Elem detailsBtn = new Elem(By.cssSelector(".js-show-details"), "Show details button");
    public Elem commentInput = new Elem (By.cssSelector(".js-new-comment-input"), "Comment text area");
    public Elem saveCommentBtn = new Elem (By.cssSelector(".js-add-comment"), "Save comment button");

    public Elem deleteCheckListBtn = new Elem (By.cssSelector(".js-confirm-delete"), "Delete checklist button");
    public Elem deleteConfirm = new Elem (By.cssSelector(".js-confirm"), "Delete confirmation button");
    public Elem membersList = new Elem (By.cssSelector(".js-card-detail-members"), "List of the added members");

    public void open (String url){
        get(url);
        Assert.assertTrue(isOpened(),"Page Card is not Opened");
    }

    public boolean isOpened(){
        return membersBtn.isPresent() && driver().getCurrentUrl().contains(Constants.URL + PATH);
    }

    public void addMember(){
        membersBtn.click();
        selectMemberBtn.click();
        membersBtn.click();
        Assert.assertTrue(membersList.isPresent(), "Member is not added");
    }

    public void addLabel (){
        labelsBtn.click();
        yellowLabelBtn.click();
        closePopUpBtn.click();
        Assert.assertTrue(yellowLabelBtn.isPresent(), "Label is not added");
    }

    public void addCheckList(){
        checklistBtn.click();
        checklistNameInput.type("Check list test");
        addChecklistBtn.click();
        checkListItemInput.type("Check list item test");
        confirmChecklistItemBtn.click();
        Assert.assertTrue(checklistItem.isPresent(), "Check list is not added");
    }

    public void convertCheckListItemToCard (){
        checklistItemMenu.click();
        ConvertToCardchecklistItemMenu.click();
        Assert.assertTrue(!checklistItemRow.isPresent());

    }

    public void deleteChecklist (){
        addChecklistBtn.click();
        checkListItemInput.type("Check list item to delete");
        confirmChecklistItemBtn.click();
        checklistItemCheckbox.click();
        checklistItemMenu.click();
        deleteChecklistItemBtn.click();
        deleteCheckListBtn.click();
        confirmDeleteBtn.click();
        Assert.assertTrue(!checkListItemInput.isPresent(), "Checklist is not deleted");

    }


    public void addAttachment () {
        attachmentBtn.click();
        linkInput.type("Link test");

        linkNameInput.type("Link name test");
        attachBtn.click();
        Assert.assertTrue(attachmentPreview.isPresent(), "Attachment is not added");
    }

    public void deleteAttachment (){
        deleteAttachmentBtn.click();
        confirmDeleteBtn.click();
        Assert.assertTrue(!attachmentPreview.isPresent(), "Attachment is not deleted");
    }

    public void copyCard (String boardId, String listId) throws InterruptedException {
        copyCardBtn.click();
        boardSelect.select(boardId);
        listOptionValue.find();
        listSelect.select(listId);
        createCardBtn.click();

    }

}