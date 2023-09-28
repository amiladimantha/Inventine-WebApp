package com.inventine.dao.interface_;

import com.inventine.model.FinanceAdmin;
import com.inventine.model.ForumReply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ForumReplyDaoInterface {

    public boolean create(ForumReply forumReply);

    public ForumReply getForumReply(String forumReplyId);

    public ForumReply getForumReplyLatest(String forumReplyId);

//    public ForumReply getForumReplyPI(String forumTopicId);

    public List<ForumReply> getForumReplys(String condition);

    public boolean update(ForumReply forumReply);

    public int getCount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);
}