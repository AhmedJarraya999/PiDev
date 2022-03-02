/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxblog.entity.Comment;
import javafxblog.entity.Experience;
import javafxblog.utils.ConnetionSingletion;

/**
 *
 * @author tasni
 */
public class CommentService implements CommentServiceImp<Comment> {
    
    private static CommentService instance;
    Connection cnx = ConnetionSingletion.getInstance().getCnx();
    private Statement statement;
    private ResultSet resultSet;
    
    public CommentService() {
        ConnetionSingletion cs=ConnetionSingletion.getInstance();
        try {
            statement=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CommentServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static CommentService getInstance(){
        if(instance==null)
            instance=new CommentService();
        return instance;
    }


    @Override
    public void add_comment(Comment comment) {
             String req="insert into comment (author,content,date,likes) values ('"+comment.getComment_author()+"','"+comment.getComment_content()+"','"+comment.getComment_date()+"','0')";
        try {
            statement.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete_comment(int id) {
          try {
         String req="delete from comment where id='"+id+"'";
         PreparedStatement preparedStatement = cnx.prepareStatement(req);
         preparedStatement.executeUpdate();
      } catch (SQLException ex) {
          System.err.println(ex.getMessage());
        }
    }

    @Override
    public void update_comment(Comment comment) {
        try {

            String req = "UPDATE comment SET content = '"+comment.getComment_content();
            if (statement.executeUpdate(req) > 0) {
                System.out.println("Hotel updated");
            }
        } catch (SQLException ex) {

        }
    }

    @Override
    public List<Comment> show()throws SQLException{
            List<Comment> comments = new ArrayList<>();
        String req = "select * from comment";
        statement = cnx.createStatement();
        ResultSet rst = statement.executeQuery(req);

        while (rst.next()) {
            Comment c = new Comment(resultSet.getInt("id"),//or rst.getInt(1)
                    resultSet.getInt("author"),
                    resultSet.getString("content"),
                    resultSet.getString("date"),                    
                    resultSet.getInt("likes"));

            comments.add(c);
        }
        return comments;
    }
    
}
