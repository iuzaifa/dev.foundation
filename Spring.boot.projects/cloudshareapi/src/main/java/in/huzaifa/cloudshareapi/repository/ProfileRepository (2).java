package in.huzaifa.cloudshareapi.repository;

import in.huzaifa.cloudshareapi.document.ProfileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository  extends MongoRepository<ProfileDocument, String> {


    ProfileDocument findByClerkId(String clerkId);

    Optional<ProfileDocument> findByEmail(String email);


    boolean existsByClerkId(String clerkId);

}
