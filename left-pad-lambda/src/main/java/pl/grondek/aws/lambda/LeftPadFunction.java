package pl.grondek.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LeftPadFunction implements RequestHandler<PadRequest, String> {
    @Override
    public String handleRequest(PadRequest request, Context context) {
        if (request.getSize() < request.getString().length()) {
            return request.getString();
        } else {
            final char[] input = request.getString().toCharArray();
            char[] output = new char[request.getSize()];
            final int paddingSize = request.getSize() - input.length;

            for (int i = 0; i < paddingSize; i++) {
                output[i] = request.getCharacter();
            }

            System.arraycopy(input, 0, output, paddingSize, input.length);
            return String.valueOf(output);
        }
    }
}
