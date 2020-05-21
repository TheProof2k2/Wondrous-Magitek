package net.dragonhill.wondrousmagitek.blocks.areastabilizer;

import net.dragonhill.wondrousmagitek.ui.InventoryScreen;
import net.dragonhill.wondrousmagitek.ui.widgets.RangeSelector;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import org.lwjgl.opengl.GL11;

public class AreaStabilizerScreen extends InventoryScreen<AreaStabilizerContainer> {
	RangeSelector rangeSelector;
	Button button;

	public AreaStabilizerScreen(final AreaStabilizerContainer container, final PlayerInventory inventory, final ITextComponent title) {
		super(container, inventory, title);
	}

	@Override
	protected void init() {
		super.init();

		final int x = this.getClientX();
		final int y = this.getClientY();

		this.addButton(this.rangeSelector = new RangeSelector(x, y + 27, 50, 16, 0, 100, 15));
		this.addButton(this.button = new Button(x, y + 50, 60,20, I18n.format("ui.wondrousmagitek.area_stabilizer.visualize_button"), button -> {}));
	}

	@Override
	protected void drawClientBackground(float partialTicks, int mouseX, int mouseY) { }

	@Override
	protected void drawClientForeground(int mouseX, int mouseY) {
		this.font.drawString(this.title.getFormattedText(), 8f, 5f, 0xFF000000);

		GL11.glPushMatrix();
		GL11.glScalef(0.8f, 0.8f, 0.8f);
		this.font.drawString(I18n.format("ui.wondrousmagitek.area_stabilizer.radius_select", 20), 10f, 30f, 0xFF000000);
		GL11.glPopMatrix();
	}
}