package org.example.sevanidhi.util;

import org.example.sevanidhi.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FraudDetectionUtil {
    private static final Logger log = LoggerFactory.getLogger(FraudDetectionUtil.class);

    /**
     * Checks if an Aadhaar number has already been used for multiple applications.
     * Returns true if more than one application exists with the same Aadhaar.
     *
     * @param repo the ApplicationRepository
     * @param aadhaar the Aadhaar number to check
     * @return true if Aadhaar is duplicated (more than 1 application), false otherwise
     */
    public static boolean isDuplicateAadhaar(
            ApplicationRepository repo,
            String aadhaar) {

        if (aadhaar == null || aadhaar.trim().isEmpty()) {
            log.warn("Aadhaar number is null or empty");
            return false;
        }

        long count = repo.countByUserAadhaarNumber(aadhaar);
        boolean isDuplicate = count > 1;

        if (isDuplicate) {
            log.warn("Duplicate Aadhaar detected: {} with {} applications", aadhaar, count);
        }

        return isDuplicate;
    }
}
