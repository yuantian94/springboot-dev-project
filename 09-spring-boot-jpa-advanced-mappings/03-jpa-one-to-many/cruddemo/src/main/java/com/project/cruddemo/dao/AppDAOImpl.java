package com.project.cruddemo.dao;

import com.project.cruddemo.entity.Course;
import com.project.cruddemo.entity.Instructor;
import com.project.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements  AppDAO{

    // define field for entity manager

    // inject entity manager using constructor injection

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        // retrieve instructor
        Instructor InstructorToDelete = entityManager.find(Instructor.class, theId);

        entityManager.remove(InstructorToDelete);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        // remove the associated object reference
        // break bi-directional link
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {
        // create query

        TypedQuery<Course> query = entityManager.createQuery(
                                    "from Course where instructor.id = :data", Course.class);
        query.setParameter("data",theId);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetchCourses(int theId) {
        // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                                            "select i from Instructor i "
                                            + "JOIN FETCH i.courses "
                                            + "where i.id = :data", Instructor.class);

        query.setParameter("data", theId);

        // execute query
        Instructor instructor = query.getSingleResult();
        return instructor;

    }
}
