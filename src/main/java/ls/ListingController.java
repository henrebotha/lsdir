package ls;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListingController {
    // private static final String template = "Henlo! %s";

    @RequestMapping("/listing")
    public Listing listing(@RequestParam(value = "path", defaultValue = "") String path,
                           @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "100") int size) {
        return new Listing("/filesystem" + path, page, size);
    }
}