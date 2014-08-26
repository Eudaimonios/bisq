/*
 * This file is part of Bitsquare.
 *
 * Bitsquare is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bitsquare is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bitsquare. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bitsquare.gui.components.processbar;

import java.util.List;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class ProcessStepBar<T> extends Control
{


    private List<ProcessStepItem> processStepItems = null;

    public ProcessStepBar()
    {
    }


    public ProcessStepBar(List<ProcessStepItem> processStepItems)
    {
        this.processStepItems = processStepItems;
    }


    @Override
    protected Skin<?> createDefaultSkin()
    {
        return new ProcessStepBarSkin<>(this);
    }


    List<ProcessStepItem> getProcessStepItems()
    {
        return processStepItems;
    }

    public void setProcessStepItems(List<ProcessStepItem> processStepItems)
    {
        this.processStepItems = processStepItems;
        if (getSkin() != null)
        {
            ((ProcessStepBarSkin) getSkin()).dataChanged();
        }
    }

    public void next()
    {
        ((ProcessStepBarSkin) getSkin()).next();
    }
}
