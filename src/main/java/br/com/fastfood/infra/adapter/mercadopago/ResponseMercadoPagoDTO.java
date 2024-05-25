package br.com.fastfood.infra.adapter.mercadopago;

public class ResponseMercadoPagoDTO {
    public ResponseMercadoPagoDTO(Boolean pago, String mensagem) {
        this.pago = pago;
        this.mensagem = mensagem;
    }

    private Boolean pago;
    private String mensagem;

    public Boolean getPago() {
        return pago;
    }

    public String getMensagem() {
        return mensagem;
    }
}
