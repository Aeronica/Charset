/*
 * Copyright (c) 2015-2016 Adrian Siekierka
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.asie.charset.tweaks.minecart;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.ResourceLocation;

public class ModelMinecartWrapped extends ModelBase {
	private final ModelBase parent;

	public ModelMinecartWrapped(ModelBase parent) {
		this.parent = parent;
	}

	public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {
		if (entityIn instanceof EntityMinecart) {
			EntityMinecart minecart = (EntityMinecart) entityIn;
			MinecartDyeable dyeable = MinecartDyeable.get(minecart);
			if (dyeable != null && dyeable.getColor() >= 0) {
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("charsettweaks:textures/entity/minecart.png"));

				float r = (float) ((dyeable.getColor() >> 16) & 255) / 255.0f;
				float g = (float) ((dyeable.getColor() >> 8) & 255) / 255.0f;
				float b = (float) (dyeable.getColor() & 255) / 255.0f;
				GlStateManager.color(r, g, b);
			}
		}

		parent.render(entityIn, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale);

		GlStateManager.color(1.0f, 1.0f, 1.0f);
	}
}
