/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.dao;

import java.sql.SQLException;
import java.util.List;
import javafxblog.entity.Comment;

/**
 *
 * @author tasni
 */
public interface CommentServiceImp<Comment> {
    
    public void add_comment(Comment comment);
    public void delete_comment(int id);
    public void update_comment(Comment comment);
    public List<Comment> show()throws SQLException;
    
}
