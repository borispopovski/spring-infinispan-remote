package mk.iskratel.shape.infinispanremote.controller;

import mk.iskratel.shape.infinispanremote.service.IRemoteCacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class RemoteCacheController {

  private IRemoteCacheService testService;

  public RemoteCacheController(IRemoteCacheService testService) {
    this.testService = testService;
  }

  @GetMapping("/getName")
  public String getName(@RequestParam String id) {
    return testService.getName(id);
  }

  @PostMapping("/createName")
  public void createName(@RequestParam String name) {
    testService.createName(name);
  }

}
