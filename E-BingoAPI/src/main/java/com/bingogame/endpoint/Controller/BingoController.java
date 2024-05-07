    package com.bingogame.endpoint.Controller;

    import com.bingogame.endpoint.Model.BingoResponse;
    import com.bingogame.endpoint.Service.BingoService;
    import com.fasterxml.jackson.core.JsonProcessingException;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/www.hyeumine.com")
    public class BingoController {

        private final BingoService bingoService;

        @Autowired
        public BingoController(BingoService bingoService) {
            this.bingoService = bingoService;
        }


        @GetMapping("/getcard.php")
        public ResponseEntity<BingoResponse> getCard(@RequestParam String bcode) throws JsonProcessingException {
            BingoResponse bingoCard = bingoService.getCard(bcode);
            if(bingoCard != null){
                return ResponseEntity.ok(bingoCard);
            }else{
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/checkwin.php")
        public ResponseEntity<String> checkWin(@RequestParam String playcard_token) {
            return bingoService.checkWin(playcard_token);
        }
    }
