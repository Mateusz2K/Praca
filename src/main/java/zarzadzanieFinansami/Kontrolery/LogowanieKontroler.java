package zarzadzanieFinansami.Kontrolery;

//import serwisy.AutoryzacjaUsługa;


//@RestController
//@RequestMapping("api/login")
//public class LogowanieKontroler {
//
//    private static final Logger logger = LoggerFactory.getLogger(LogowanieKontroler.class);
//
//    private final AutoryzacjaUsługa autoryzacjaUsługa;
//
//    @Autowired
//    public LogowanieKontroler(AutoryzacjaUsługa autoryzacjaUsługa) {
//        this.autoryzacjaUsługa = autoryzacjaUsługa;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@Valid @RequestBody UzytkownikDTO request) {
//        try {
//            String token = autoryzacjaUsługa.autoryzacja(request.getEmail(), request.getHaslo());
//            logger.info("Użytkownik pomyślnie zalogowany: {}", request.getEmail());
//            return ResponseEntity.ok(new LoginOdpowiedzDTO(token));
//        } catch (RuntimeException e) {
//            logger.warn("Nieudana próba logowania: {}", request.getEmail(), e);
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nieprawidłowe dane logowania");
//        }
//    }
//}
