/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.core.fee;

import bisq.core.offer.Offer;
import bisq.core.offer.OpenOffer;
import bisq.core.provider.mempool.FeeValidationStatus;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;

public class FeeValidationTests {
    @Test
    void createOpenBsqOffer() {
        var openOffer = new OpenOffer(mock(Offer.class));
        assertThat(openOffer.getFeeValidationStatus(), is(equalTo(FeeValidationStatus.NOT_CHECKED_YET)));
    }

    @Test
    void createOpenBsqOfferWithSecondConstructor() {
        var openOffer = new OpenOffer(mock(Offer.class), OpenOffer.State.AVAILABLE);
        assertThat(openOffer.getFeeValidationStatus(), is(equalTo(FeeValidationStatus.NOT_CHECKED_YET)));
    }

    @Test
    void createOpenOfferWithTriggerPrice() {
        var openOffer = new OpenOffer(mock(Offer.class), 42_000);
        assertThat(openOffer.getFeeValidationStatus(), is(equalTo(FeeValidationStatus.NOT_CHECKED_YET)));
    }
}
