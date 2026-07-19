package in.huzaifa.cloudshareapi.serivce;

import in.huzaifa.cloudshareapi.document.ProfileDocument;
import in.huzaifa.cloudshareapi.dto.ProfileDto;
import in.huzaifa.cloudshareapi.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDto createProfile(ProfileDto profileDto){

        if (profileRepository.existsByClerkId(profileDto.getClerkId())){
            return updateProfile(profileDto);
        }
        ProfileDocument profile = ProfileDocument.builder()
                .clerkId(profileDto.getClerkId())
                .email(profileDto.getEmail())
                .firstname(profileDto.getFirstname())
                .lastname(profileDto.getLastname())
                .photoUrl(profileDto.getPhotoUrl())
                .credits(5)
                .createAt(Instant.now())
                .build();
        profile = profileRepository.save(profile);
        return ProfileDto.builder()
                .id(profile.getId())
                .clerkId(profile.getClerkId())
                .email(profile.getEmail())
                .firstname(profile.getFirstname())
                .lastname(profile.getLastname())
                .photoUrl(profile.getPhotoUrl())
                .credits(profile.getCredits())
                .createAt(profile.getCreateAt())
                .build();
    }

    public ProfileDto updateProfile(ProfileDto profileDto){
        ProfileDocument existingProfile = profileRepository.findByClerkId(profileDto.getClerkId());
        if (existingProfile != null){
            if (profileDto.getEmail() != null &&  !profileDto.getEmail().isEmpty()){
                existingProfile.setEmail(profileDto.getEmail());
            }
            if (profileDto.getFirstname() != null &&  !profileDto.getFirstname().isEmpty()){
                existingProfile.setFirstname(profileDto.getFirstname());
            }
            if (profileDto.getLastname() != null &&  !profileDto.getLastname().isEmpty()){
                existingProfile.setLastname(profileDto.getLastname());
            }
            if (profileDto.getPhotoUrl() != null &&  !profileDto.getPhotoUrl().isEmpty()){
                existingProfile.setPhotoUrl(profileDto.getPhotoUrl());
            }
            profileRepository.save(existingProfile);
            return ProfileDto.builder()
                    .id(existingProfile.getId())
                    .clerkId(existingProfile.getClerkId())
                    .email(existingProfile.getEmail())
                    .firstname(existingProfile.getFirstname())
                    .lastname(existingProfile.getLastname())
                    .createAt(existingProfile.getCreateAt())
                    .credits(existingProfile.getCredits())
                    .photoUrl(existingProfile.getPhotoUrl())
                    .build();
        }
        return null;
    }

    public boolean existsByClerkId(String clerkId) {
        return profileRepository.existsByClerkId(clerkId);
    }

    public void deleteProfile(String clerkId){
        ProfileDocument existingProfile = profileRepository.findByClerkId(clerkId);
        if (existingProfile != null){
            profileRepository.delete(existingProfile);
        }
    }
}
